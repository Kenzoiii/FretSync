import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fretsync.R

class SlideAdapter(private val slides: List<Slide>) :
    RecyclerView.Adapter<SlideAdapter.SlideViewHolder>() {

    inner class SlideViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val imageView: ImageView = view.findViewById(R.id.imageSlide)
        private val titleView: TextView = view.findViewById(R.id.titleSlide)
        private val descView: TextView = view.findViewById(R.id.descSlide)

        fun bind(slide: Slide) {
            imageView.setImageResource(slide.image)
            titleView.text = slide.title
            descView.text = slide.description
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SlideViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.slide_item, parent, false)
        return SlideViewHolder(view)
    }

    override fun onBindViewHolder(holder: SlideViewHolder, position: Int) {
        holder.bind(slides[position])
    }

    override fun getItemCount(): Int = slides.size
}
