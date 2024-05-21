package util

import coil3.ImageLoader
import coil3.PlatformContext
import coil3.disk.DiskCache
import coil3.memory.MemoryCache
import coil3.request.CachePolicy
import coil3.request.crossfade
import coil3.util.DebugLogger
import okio.FileSystem

fun getAsyncImageLoader(context: PlatformContext): ImageLoader {
    return ImageLoader.Builder(context)
        .crossfade(true)
        .logger(DebugLogger())
        .memoryCachePolicy(CachePolicy.ENABLED)
        .memoryCache {
            MemoryCache.Builder()
                .maxSizePercent(context, 0.3)
                .strongReferencesEnabled(true)
                .build()
        }
        .diskCache {
            newDiskCache()
        }
        .build()
}

fun newDiskCache(): DiskCache {
    return DiskCache.Builder()
        .directory(FileSystem.SYSTEM_TEMPORARY_DIRECTORY / "images")
        .maxSizeBytes(512L * 1024 * 1024)
        .build()
}