package viewpager.chy.howard.com.txcloudvideo

import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v7.app.AppCompatActivity
import com.tencent.rtmp.TXVodPlayConfig
import com.tencent.rtmp.TXVodPlayer
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val mUrl =
        "https://video-social.kkmh.com/3dd237e0vodtransgzp1400077015/353ab86a5285890787061346042/v.f30436.mp4"

    private val mVodPlayer: TXVodPlayer by lazy {
        TXVodPlayer(this)
    }

    @RequiresApi(Build.VERSION_CODES.KITKAT)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setConfig()
        mVodPlayer.startPlay(mUrl)
        mVodPlayer.setPlayerView(tXCloudVideoView)
        button.setOnClickListener {
            mVodPlayer.setPlayerView(tXCloudVideoView1)
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        mVodPlayer.stopPlay(true) // true 代表清除最后一帧画面
    }

    private fun setConfig() {
        val mConfig = TXVodPlayConfig()
        mConfig.setCacheFolderPath(applicationContext.filesDir.absolutePath + "/txcache")
        mConfig.setMaxCacheItems(10)
        mVodPlayer.setConfig(mConfig)
    }
}
