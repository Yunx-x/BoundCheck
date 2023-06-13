package com.example.myapplication.list

data class TestData(
    val code: Int,
    val `data`: Data,
    val message: String,
    val success: Boolean
)

data class Data(
    val taskItemVoList: List<TaskItemVo>,
)

data class TaskItemVo(
    val childItemList: List<TaskItemVo>?,
    val contentName: String,
    var isExpend: Boolean = false//自定义一条标识当前节点是展开还是收缩状态的数据
)
