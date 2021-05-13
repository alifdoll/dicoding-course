package com.alif.academy.ui.academy

import androidx.lifecycle.ViewModel
import com.alif.academy.data.CourseEntity
import com.alif.academy.utils.DataDummy

class AcademyViewModel : ViewModel(){
    fun getCourse() : List<CourseEntity> = DataDummy.generateDummyCourse()
}