package com.novita.ugd89_a_10745_project1

import android.content.Context
import android.graphics.Camera
import android.util.Log
import android.view.SurfaceHolder
import android.view.SurfaceView
import java.io.IOException

class CameraView(context: Context?, private val  mCamera: android.hardware.Camera) : SurfaceView(context),
    SurfaceHolder.Callback{

    private val mHolder: SurfaceHolder

    init {
        mCamera.setDisplayOrientation(90)
        mHolder = holder
        mHolder.addCallback(this)
        mHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS)
    }

    override fun surfaceCreated(surfaceHolder: SurfaceHolder) {
        if(mHolder.surface== null) return
        try {
            mCamera.setPreviewDisplay(mHolder)
            mCamera.startPreview()

        }catch (e: IOException) {
            Log.d("error", "Camera Error on SurfaceCreated" + e.message)
        }
    }

    override fun surfaceChanged(p0: SurfaceHolder, p1: Int, p2: Int, p3: Int) {
        if(mHolder.surface == null) return
        try {
            mCamera.setPreviewDisplay(mHolder)
            mCamera.startPreview()

        }catch (e: IOException) {
            Log.d("error", "Camera Error on SurfaceCreated" + e.message)
        }
    }

    override fun surfaceDestroyed(p0: SurfaceHolder) {
        mCamera.stopPreview()
        mCamera.release()
    }
}