package app.lawnchair.icons

import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.drawable.AdaptiveIconDrawable
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable

open class ExtendedBitmapDrawable(
    res: Resources,
    bitmap: Bitmap,
    val isFromIconPack: Boolean
) : BitmapDrawable(res, bitmap) {

    companion object {

        @JvmStatic
        fun wrap(res: Resources, drawable: Drawable?, isFromIconPack: Boolean): Drawable? {
            if (drawable == null) return null
            val bitmap = if (drawable is BitmapDrawable && drawable.bitmap != null && !drawable.bitmap.isRecycled) {
                drawable.bitmap
            } else {
                drawableToBitmap(drawable)
            }
            return ExtendedBitmapDrawable(res, bitmap, isFromIconPack)
        }

        @JvmStatic
        val Drawable.isFromIconPack get() = (this as? ExtendedBitmapDrawable)?.isFromIconPack ?: false
    }
}
