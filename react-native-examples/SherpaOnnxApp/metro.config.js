const {getDefaultConfig, mergeConfig} = require('@react-native/metro-config');

/**
 * Metro configuration
 * https://facebook.github.io/metro/docs/configuration
 *
 * @type {import('metro-config').MetroConfig}
 */
const config = {
  watchFolders: [],
  maxWorkers: 2,
  resetCache: true,
  cacheStores: [],
  transformer: {
    minifierConfig: {
      simplify: false,
    },
  },
  resolver: {
    blockList: [
      /node_modules\/.*\/node_modules\/react-native\/.*/,
    ],
  },
  watcher: {
    healthCheck: {
      enabled: true,
      interval: 5000,
      timeout: 1000,
    },
    additionalExts: [],
  },
};

module.exports = mergeConfig(getDefaultConfig(__dirname), config);
