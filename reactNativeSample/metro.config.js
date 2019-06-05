/**
 * Metro configuration for React Native
 * https://github.com/facebook/react-native
 *
 * @format
 */
const path = require('path');
const blacklist = require('metro').createBlacklist;

module.exports = {
  transformer: {
    getTransformOptions: async () => ({
      transform: {
        experimentalImportSupport: false,
        inlineRequires: false,
      },
    }),
  },
  getBlacklistRE: function() {
  return blacklist([/node_modules\/react-native-sdk\/reactNativeSample\/.*/]);
},
    /**
     * Add "global" dependencies for our RN project here so that our local components can resolve their
   * dependencies correctly
   */
  resolver: {
    extraNodeModules: {
      "react-native-sdk": path.resolve(__dirname, "node_modules/react-native-sdk")
    }
  },
 /**
   * Add our workspace roots so that react native can find the source code for the included packages
   * in the monorepo
   */
  projectRoot: path.resolve(__dirname),
  watchFolders: [
    path.resolve(__dirname, "node_modules/react-native-sdk")
  ]
};
