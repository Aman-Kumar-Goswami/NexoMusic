package com.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.AdapterR
import com.data.Data
import com.data.MusicSession
import com.example.nexomusic.R
import com.squareup.picasso.Picasso
import com.viewmodel.MusicViewModel

class MusicList : Fragment() {
    private lateinit var recycleView: RecyclerView
    private lateinit var miniPlayer: View
    private lateinit var miniTitle: TextView
    private lateinit var miniArtist: TextView
    private lateinit var miniArt: ImageView
    private lateinit var miniPlayBtn: ImageButton

    private val viewModel: MusicViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_music_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews(view)
        setupObservers()

        MusicSession.currentTrack?.let {
            updateMiniPlayer(it)
        }

        viewModel.fetchSongs("eminem")
    }

    private fun initViews(view: View) {
        recycleView = view.findViewById(R.id.recycleViewF1)
        recycleView.layoutManager = LinearLayoutManager(requireContext())

        miniPlayer = view.findViewById(R.id.miniPlayer)
        miniTitle = view.findViewById(R.id.miniTitle)
        miniArtist = view.findViewById(R.id.miniArtist)
        miniArt = view.findViewById(R.id.miniArt)
        miniPlayBtn = view.findViewById(R.id.miniPlayBtn)

        miniPlayer.setOnClickListener {
            MusicSession.fullTrackList?.let { list ->
                navigateToMusicDisplay(ArrayList(list), MusicSession.currentIndex)
            }
        }
    }

    private fun setupObservers() {
        viewModel.musicData.observe(viewLifecycleOwner) { myData ->
            val datalist = myData?.data ?: return@observe
            if (datalist.isEmpty()) {
                Log.d("MusicList", "Data list is empty")
                return@observe
            }

            val adapter = AdapterR(requireActivity(), datalist) { selectedTrack ->
                val index = datalist.indexOf(selectedTrack)

                MusicSession.currentTrack = selectedTrack
                MusicSession.currentIndex = index
                MusicSession.fullTrackList = ArrayList(datalist)

                updateMiniPlayer(selectedTrack)
                navigateToMusicDisplay(ArrayList(datalist), index)
            }
            recycleView.adapter = adapter
        }

        viewModel.error.observe(viewLifecycleOwner) { errorMessage ->
            Log.e("MusicList", "Error fetching data: $errorMessage")
        }
    }


    private fun navigateToMusicDisplay(trackList: ArrayList<Data>, index: Int) {
        val bundle = Bundle().apply {
            putSerializable("trackList", trackList)
            putInt("currentIndex", index)
        }
        val musicDisplay = MusicDisplay().apply {
            arguments = bundle
        }
        parentFragmentManager.beginTransaction()
            .replace(R.id.containerFragment, musicDisplay)
            .addToBackStack(null)
            .commit()
    }

    private fun updateMiniPlayer(track: Data) {
        miniTitle.text = track.title
        miniArtist.text = track.artist.name
        Picasso.get().load(track.album.cover).into(miniArt)
        miniPlayer.visibility = View.VISIBLE
    }
}
