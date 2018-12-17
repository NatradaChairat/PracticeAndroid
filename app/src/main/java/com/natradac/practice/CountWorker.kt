package com.natradac.practice

import android.content.Context
import android.util.Log
import androidx.work.*

class CountWorker(context: Context,  params : WorkerParameters) : Worker(context, params) {

    val TAG = "TEST_WORK_MANAGER"
    override fun doWork(): Result {
        counting()
        return Result.success()
    }

    private fun counting(){
        Log.d( TAG, "Test")

    }
}