package com.alif.academy.ui.bookmark

import com.alif.academy.data.CourseEntity

interface BookmarkFragmentCallback {
    fun onShareClick(course: CourseEntity)

}
