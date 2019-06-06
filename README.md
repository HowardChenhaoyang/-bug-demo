# -bug-demo
sdk版本：测试了5.2.5539版本和6.3.7089版本，存在同样的问题
平台：Android
系统：5.0 oppo手机。估计6.0以下的手机都存在相同问题。

涉及到的api：TXCloudVideoView 、 TXVodPlayer

复现代码：

视频开始播放后，调用TXVodPlayer.setPlayerView方法切换TXVodPlayer渲染的目标TXCloudVideoView

tXVodPlayer.setPlayerView(mTxCloudVideoView) 出现crash问题。

