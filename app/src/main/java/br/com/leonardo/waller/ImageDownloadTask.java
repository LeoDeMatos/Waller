package br.com.leonardo.waller;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.os.PowerManager;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

import br.com.leonardo.waller.view.DetailActivity;

/**
 * Created by Leonardo de Matos on 26/04/17.
 */

public class ImageDownloadTask extends AsyncTask<String, Integer, String> {

    private Context mContext;
    private PowerManager.WakeLock mWakeLock;
    private DetailActivity.ImageDownloadCallback mDownloadCallback;
    private Bitmap mPhoto;
    private boolean isSave;

    public ImageDownloadTask(Context context, Bitmap bitmap, boolean isSave, DetailActivity.ImageDownloadCallback callback) {
        this.mContext = context;
        mDownloadCallback = callback;
        this.mPhoto = bitmap;
        this.isSave = isSave;
    }

    @Override
    protected String doInBackground(String... sUrl) {
        savePicture(mPhoto);
        return null;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        // take CPU lock to prevent CPU from going off if the user
        // presses the power button during download
        PowerManager pm = (PowerManager) mContext.getSystemService(Context.POWER_SERVICE);
        mWakeLock = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK,
                getClass().getName());
        mWakeLock.acquire();

    }

    @Override
    protected void onPostExecute(String result) {
        mWakeLock.release();
        mDownloadCallback.onFinish();
    }

    private void savePicture(Bitmap resource) {
        File folder = new File(Environment.getExternalStorageDirectory() +
                File.separator + "Waller");
        boolean success = true;
        if (!folder.exists()) {
            success = folder.mkdirs();
        }
        if (success) {
            File file = new File(folder.toString(), "wallpaper-" + UUID.randomUUID().toString() + ".png"); // the File to save , append increasing numeric counter to prevent files from getting overwritten.
            FileOutputStream out = null;
            try {
                out = new FileOutputStream(file);
                resource.compress(Bitmap.CompressFormat.PNG, 100, out);

                if (!isSave) {
                    setWallpaper(file, resource);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (out != null) {
                        out.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    private void setWallpaper(File resource, Bitmap bitmapResource) {
        try {
            Intent intent = new Intent(Intent.ACTION_ATTACH_DATA);
            intent.addCategory(Intent.CATEGORY_DEFAULT);
            intent.setDataAndType(Uri.fromFile(resource), "image/png");
            intent.putExtra("mimeType", "image/jpeg");
            mContext.startActivity(Intent.createChooser(intent, "Waller set photo as:"));
        } catch (Exception e) {

            Intent intent = new Intent(Intent.ACTION_SET_WALLPAPER);
            mContext.startActivity(Intent.createChooser(intent, "Select Wallpaper"));
            try {
                mContext.setWallpaper(bitmapResource);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
    }
}

