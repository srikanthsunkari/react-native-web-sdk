
import { AppRegistry } from "react-native";
// import App from "./App";
import LoadMore from './LoadMore'
// export default App;
import { name as appName } from './app.json';

import React from 'react';
import ReactDOM from 'react-dom';
import * as serviceWorker from './serviceWorker';
// console.log("PlatformOS", Platform.OS);
AppRegistry.registerComponent(appName, () => LoadMore);
ReactDOM.render(<LoadMore />, document.getElementById('root'));

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: http://bit.ly/CRA-PWA
serviceWorker.unregister();
// }
