package com.alif.academy.ui.bookmark

import androidx.lifecycle.ViewModel
import com.alif.academy.data.CourseEntity
import com.alif.academy.utils.DataDummy

class BookMarkViewModel : ViewModel() {

    fun getBookMarks(): List<CourseEntity> = DataDummy.generateDummyCourse()
}