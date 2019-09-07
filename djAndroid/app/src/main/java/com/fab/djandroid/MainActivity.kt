package com.fab.djandroid

import android.Manifest
import android.Manifest.permission.MANAGE_DOCUMENTS
import android.content.Context
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.view.View
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.fab.djandroid.dummy.DummyContent
import org.eclipse.paho.android.service.MqttAndroidClient
import org.eclipse.paho.client.mqttv3.*
import java.util.logging.Logger
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer

import android.provider.SyncStateContract
import androidx.fragment.app.FragmentActivity
import com.google.android.youtube.player.YouTubePlayerSupportFragment




class MainActivity : AppCompatActivity() , songFragment.OnListFragmentInteractionListener,SettingsFragment.OnFragmentInteractionListener ,
    IMqttActionListener
    {
        override fun onFailure(asyncActionToken: IMqttToken?, exception: Throwable?) {


            val Log = Logger.getLogger(MainActivity::class.java.name)
            Log.warning("mqtt failer")
        }

        override fun onSuccess(asyncActionToken: IMqttToken?) {
           // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            val Log = Logger.getLogger(MainActivity::class.java.name)
            Log.warning("mqtt succcess")
        }

        override fun onFragmentInteraction(uri: Uri) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onListFragmentInteraction(item: DummyContent.DummyItem?) {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }




     private lateinit   var myMqtt: MqttAndroidClient
    private lateinit var textMessage: TextView


        var youTubePlayer: YouTubePlayer? = null

        private var youTubePlayerFragment: YouTubePlayerSupportFragment? = null



    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {


                showFragment (R.id.fragmentContainer ,songFragment.newInstance(1) )
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {

                showFragment (R.id.fragmentContainer ,SettingsFragment.newInstance("", "") )
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {

                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }


    private  fun showFragment (frameId : Int , fr:Fragment )
    {


        val manager = getSupportFragmentManager()
        val transaction = manager.beginTransaction()
        //transaction.add(frameId, fr /*fragment*/)
        transaction.replace(frameId, fr /*fragment*/)
        transaction.commit()
    }


        override fun onCreateView(name: String, context: Context, attrs: AttributeSet): View? {
            return super.onCreateView(name, context, attrs)





        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)





        setupPermissions()

        val Log = Logger.getLogger(MainActivity::class.java.name)
        Log.warning("before mqtt")



        /*

        var uri = "tcp://m20.cloudmqtt.com:19737"

        val clientId = MqttClient.generateClientId()
        myMqtt = MqttAndroidClient(applicationContext, uri, "wqberakn")

        var token:IMqttToken
        try {
            val token = myMqtt.connect()
            token.actionCallback = object : IMqttActionListener {
                override fun onSuccess(asyncActionToken: IMqttToken)                        {
                    Log.warning( "mqtt:success ")
                    //connectionStatus = true
                    // Give your callback on connection established here
                }
                override fun onFailure(asyncActionToken: IMqttToken, exception: Throwable) {
                    //connectionStatus = false
                    Log.warning("mqtt:failure")
                    // Give your callback on connection failure here
                    exception.printStackTrace()
                }
            }
        } catch (e: MqttException) {
            // Give your callback on connection failure here
            e.printStackTrace()
        }

*/
        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)



        initializeYoutubePlayer()

        //showFragment (R.id.youtube_player_fragment ,songFragment.newInstance(1) )



    }


        private fun setupPermissions() {
            val permission = ContextCompat.checkSelfPermission(this,
               /* Manifest.permission.WAKE_LOCK*/Manifest.permission.MANAGE_DOCUMENTS)

            if (permission != PackageManager.PERMISSION_GRANTED) {
                Log.i("heyDj", "MANAGE_DOCUMENTS")
            }
        }


        private fun initializeYoutubePlayer() {



            youTubePlayerFragment = supportFragmentManager
                .findFragmentById(R.id.youtube_player_fragment) as YouTubePlayerSupportFragment?

            if (youTubePlayerFragment == null)
                return

            youTubePlayerFragment!!.initialize(/*SyncStateContract.Constants.DEVELOPER_KEY*/ "AIzaSyDwxoxSYQGFVxm4vuzMbaajFJEh401Oe0Y", object : YouTubePlayer.OnInitializedListener {

                override fun onInitializationSuccess(
                    provider: YouTubePlayer.Provider, player: YouTubePlayer,
                    wasRestored: Boolean
                ) {

                    Log.e("heyDj", "sstep 1")

                    if (!wasRestored) {
                        youTubePlayer = player


                        //set the player style default
                        youTubePlayer!!.setPlayerStyle(YouTubePlayer.PlayerStyle.DEFAULT)

                        //cue the 1st video by default
                        youTubePlayer!!.cueVideo("B_HZvQgGAf8")
                        Log.e("heyDj", "sstep 2")
                    }
                }

                override fun onInitializationFailure(arg0: YouTubePlayer.Provider, arg1: YouTubeInitializationResult) {

                    //print or show error if initialization failed
                    Log.e("heyDj", "Youtube Player View initialization failed")
                }
            })
        }
}
