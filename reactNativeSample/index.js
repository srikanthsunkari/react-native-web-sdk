/** @format */
// import MessageQueue from 'react-native/Libraries/BatchedBridge/MessageQueue';
import { AppRegistry, UIManager, Platform } from 'react-native';
// MessageQueue.spy(true);
import { name as appName } from './app.json';
import App from './src/App'
AppRegistry.registerComponent(appName, () => App);
