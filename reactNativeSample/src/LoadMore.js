import React from 'react';
import { Button, Dimensions, FlatList, View, Platform } from 'react-native';
import { LeftTransitionView } from 'react-native-sdk'
const Ch = new Array(500).fill('Ch: ').map((i, x) => `${i}${x + 1}`);
class LoadMore extends React.Component {

  startIndex = 1;
  listLength = 20;
  isloading = false;
  lastOffset = 0;
  setLength = 5;
  state = {
    data: Ch.slice(0, 20)
  }
  gList = null;

  isCloseToEnd = ({ layoutMeasurement, contentOffset, contentSize }, paddingToBottom = 0) => layoutMeasurement.height + contentOffset.y >= contentSize.height - paddingToBottom;

  mutateChannelSet = (e) => {

  }

  render() {
    const Card = (<LeftTransitionView> <View /></LeftTransitionView>);
    console.log("Card Component::", Card);
    if (true) {
      return (Card);
    }
    return (
      <View style={{ flex: 1, flexDirection: 'row' }}>
        <View style={{ flex: 30 }}>
          <FlatList
            ref={(list) => { this.gList = list }}
            onScroll={({ nativeEvent }) => {
              if (this.isCloseToEnd(nativeEvent, 125 * 4) && Dimensions.get('window').height + this.lastOffset < nativeEvent.contentOffset.y) {
                this.lastOffset = nativeEvent.contentOffset.y;
                this.gList.scrollToOffset({ animated: false, offset: nativeEvent.contentOffset.y - (145 * 7) });
                console.log(this.startIndex * this.setLength, this.setLength * (this.startIndex + 2));
                this.setState({ data: Ch.slice(this.startIndex * this.setLength, this.setLength * (this.startIndex + 3)) }, () => {
                  this.startIndex++;
                  this.lastOffset = 0;
                  console.log(this.state.data);
                })
              }
            }}
            keyExtractor={(item) => item}
            data={this.state.data}
            getItemLayout={(data, index) => ({ length: 135, offset: 135 * index, index })}
            renderItem={
              ({ item, index }) => {
                return (
                  <View
                    style={{ width: 250, height: 125, margin: 5 }}
                    text={(index + 1) % this.setLength === 0 ? item + " S: " + (index + 1) / this.setLength : item}
                    activeBackgroundColor="green"
                  />
                )
              }
            }
          />
        </View>
        <View style={{ flex: 70 }}>
          <Button onPress={() => { this.gList.scrollToIndex({ animated: true, index: 20 }); }} title="Scroll to End" />
          <View style={{ backgroundColor: 'blue', flex: 1 }} />
        </View>
      </View>
    )
  }
}


let hotWrapper = () => () => LoadMore;
if (Platform.OS === 'web') {
  const { hot } = require('react-hot-loader');
  hotWrapper = hot;
}
export default hotWrapper(module)(LoadMore);
