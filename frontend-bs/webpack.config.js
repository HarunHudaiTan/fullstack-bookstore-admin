const path = require('path');
const webpack = require('webpack');

module.exports = {
  // Your existing webpack settings
  resolve: {
    fallback: {
      "path": require.resolve("path-browserify"),
      "fs": false,
      "url": require.resolve("url/"),
      "util": require.resolve("util/"),
      "stream": require.resolve("stream-browserify"),
      "buffer": require.resolve("buffer/"),
      "crypto": require.resolve("crypto-browserify"),
      "http": require.resolve("stream-http"),
      "https": require.resolve("https-browserify"),
      "os": require.resolve("os-browserify/browser"),
      "assert": require.resolve("assert/"),
      "zlib": require.resolve("browserify-zlib"),
      "process/browser": require.resolve("process/browser"),
      "querystring": require.resolve("querystring-es3"),
      "net": false
    }
  },
  plugins: [
    new webpack.ProvidePlugin({
      Buffer: ['buffer', 'Buffer'],
      process: 'process/browser'
    })
  ]
};
