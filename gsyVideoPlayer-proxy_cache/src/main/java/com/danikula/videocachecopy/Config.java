package com.danikula.videocachecopy;

import com.danikula.videocachecopy.file.DiskUsage;
import com.danikula.videocachecopy.file.FileNameGenerator;
import com.danikula.videocachecopy.headers.HeaderInjector;
import com.danikula.videocachecopy.sourcestorage.SourceInfoStorage;

import java.io.File;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.TrustManager;

/**
 * Configuration for proxy cache.
 *
 * @author Alexey Danilov (danikula@gmail.com).
 */
class Config {

    public final File cacheRoot;
    public final FileNameGenerator fileNameGenerator;
    public final DiskUsage diskUsage;
    public final SourceInfoStorage sourceInfoStorage;
    public final HeaderInjector headerInjector;
    public final HostnameVerifier v;
    public final TrustManager[] trustAllCerts;

    Config(File cacheRoot, FileNameGenerator fileNameGenerator, DiskUsage diskUsage, SourceInfoStorage sourceInfoStorage, HeaderInjector headerInjector, HostnameVerifier v, TrustManager[] trustAllCerts) {
        this.cacheRoot = cacheRoot;
        this.fileNameGenerator = fileNameGenerator;
        this.diskUsage = diskUsage;
        this.sourceInfoStorage = sourceInfoStorage;
        this.headerInjector = headerInjector;
        this.v = v;
        this.trustAllCerts = trustAllCerts;
    }

    File generateCacheFile(String url) {
        String name = fileNameGenerator.generate(url);
        return new File(cacheRoot, name);
    }

}
