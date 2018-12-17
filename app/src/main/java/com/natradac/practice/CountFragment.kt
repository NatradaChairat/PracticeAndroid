package com.natradac.practice

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.work.Constraints
import androidx.work.NetworkType
import androidx.work.PeriodicWorkRequest
import androidx.work.WorkManager
import java.util.concurrent.TimeUnit

class CountFragment : Fragment() {

    val constraint = Constraints.Builder().apply {
        setRequiredNetworkType(NetworkType.CONNECTED)
    }.build()

    private val periodicWorkRequest = PeriodicWorkRequest.Builder(CountWorker::class.java, 15, TimeUnit.MINUTES)
            .apply { setConstraints(constraint) }.build()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_count, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        WorkManager.getInstance().enqueue(periodicWorkRequest)
    }


    companion object {
        fun newInstance(): CountFragment{
            return CountFragment()
        }

    }
}