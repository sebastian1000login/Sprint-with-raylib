package com.mycompany.sprintproject.Utils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.Map;

public class AssetLoader {
    private static final Map<String, String> tempFileCache = new HashMap<>();

    /**
     * Resolves the real file system path of a given asset.
     * If the asset exists directly on the local filesystem (development mode),
     * it returns that path directly.
     * If not (packaged mode), it loads the asset from JAR resources, extracts
     * it to a temporary file, and returns the path to that temporary file.
     *
     * @param path The relative asset path (e.g., "Utils/Sounds/BGM/Stage1.wav")
     * @return The absolute path to a file that can be loaded by Raylib
     */
    public static String getAssetPath(String path) {
        if (path == null) {
            return null;
        }

        // First check if the file exists directly in the filesystem
        File file = new File(path);
        if (file.exists()) {
            return file.getAbsolutePath();
        }

        // If not, see if we have already extracted this resource
        if (tempFileCache.containsKey(path)) {
            return tempFileCache.get(path);
        }

        // Try to load as a classpath resource.
        // Paths inside JAR resources should use forward slashes.
        String resourcePath = path.replace('\\', '/');
        if (!resourcePath.startsWith("/")) {
            resourcePath = "/" + resourcePath;
        }

        try (InputStream is = AssetLoader.class.getResourceAsStream(resourcePath)) {
            if (is == null) {
                // If not found in classpath, return original path and let raylib try it (and fail or succeed)
                System.err.println("[AssetLoader] WARNING: Asset not found on filesystem or classpath: " + path);
                return path;
            }

            // Determine file prefix and suffix
            String prefix = "sprint_asset_";
            String suffix = "";
            int lastDot = path.lastIndexOf('.');
            if (lastDot != -1) {
                suffix = path.substring(lastDot);
            }

            // Create a temp file
            File tempFile = File.createTempFile(prefix, suffix);
            tempFile.deleteOnExit();

            // Copy resource content to temp file
            Files.copy(is, tempFile.toPath(), StandardCopyOption.REPLACE_EXISTING);

            String absolutePath = tempFile.getAbsolutePath();
            tempFileCache.put(path, absolutePath);
            System.out.println("[AssetLoader] Extracted classpath resource " + path + " to: " + absolutePath);
            return absolutePath;
        } catch (IOException e) {
            System.err.println("[AssetLoader] ERROR: Failed to extract classpath resource: " + path);
            e.printStackTrace();
            return path;
        }
    }
}
