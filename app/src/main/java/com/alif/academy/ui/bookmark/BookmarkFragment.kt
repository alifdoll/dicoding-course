package com.alif.academy.ui.bookmark

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ShareCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.alif.academy.R
import com.alif.academy.data.CourseEntity
import com.alif.academy.databinding.FragmentBookmarkBinding
import com.alif.academy.utils.DataDummy

class BookmarkFragment : Fragment(), BookmarkFragmentCallback {

    lateinit var  fragmentBookMarkBinding: FragmentBookmarkBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        fragmentBookMarkBinding = FragmentBookmarkBinding.inflate(inflater, container, false)
        return fragmentBookMarkBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(activity != null){
            val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[BookMarkViewModel::class.java]
            val courses = viewModel.getBookMarks()
            val adapter = BookmarkAdapter(this)
            adapter.setCourses(courses)

            with(fragmentBookMarkBinding.rvBookmark){
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                this.adapter = adapter
            }
        }
    }

    override fun onShareClick(course: CourseEntity) {
        if (activity != null){
            val mimeType = "text/plain"
            ShareCompat.IntentBuilder
                    .from(requireActivity())
                    .setType(mimeType)
                    .setChooserTitle("Bagikan Aplikasi ini sekarang.")
                    .setText(resources.getString(R.string.share_text, course.title))
                    .startChooser()
        }
    }

}