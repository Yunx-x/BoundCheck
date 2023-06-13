package com.example.myapplication.list

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.google.gson.Gson

class ListActivity : AppCompatActivity() {
    val data =
        "{\"code\":0,\"message\":\"success\",\"data\":{\"id\":4361,\"referId\":null,\"name\":\"培训任务040801\",\"coverUrl\":\"https://hrss-pro.oss-cn-beijing.aliyuncs.com/hrss/image/4a9362780a2244a2be2e92baddced4aa-村外.jpg\",\"cycleType\":3,\"applyStartTime\":null,\"applyEndTime\":null,\"startTime\":null,\"endTime\":null,\"courseNum\":1,\"learnTotalTime\":1623,\"studyProcess\":66,\"description\":\"<p>培训任务介绍</p >\",\"lockMode\":1,\"lockCourseRate\":null,\"lockExamCondition\":0,\"isFormCommit\":0,\"isAddOfflinTranining\":0,\"taskItemVoList\":[{\"id\":12004,\"taskId\":4361,\"courseId\":null,\"refId\":null,\"type\":2,\"contentId\":4059,\"status\":2,\"ownerId\":null,\"contentName\":\"课程4801\",\"parentId\":0,\"stageName\":null,\"sort\":1,\"isLimitTime\":null,\"contentStartTime\":null,\"contentEndTime\":null,\"isLiveReplay\":0,\"isReplay\":0,\"replayResourceId\":null,\"submitStatus\":0,\"learnTotalTime\":1623,\"studyProcess\":66,\"isLocked\":null,\"childItemList\":[{\"id\":10091,\"taskId\":null,\"courseId\":4059,\"refId\":null,\"type\":null,\"contentId\":null,\"status\":null,\"ownerId\":null,\"contentName\":\"节点1\",\"parentId\":12004,\"stageName\":null,\"sort\":null,\"isLimitTime\":null,\"contentStartTime\":null,\"contentEndTime\":null,\"isLiveReplay\":0,\"isReplay\":0,\"replayResourceId\":null,\"submitStatus\":0,\"learnTotalTime\":0,\"studyProcess\":null,\"isLocked\":false,\"childItemList\":[{\"id\":10092,\"taskId\":null,\"courseId\":4059,\"refId\":null,\"type\":null,\"contentId\":null,\"status\":null,\"ownerId\":null,\"contentName\":\"节点11\",\"parentId\":10091,\"stageName\":null,\"sort\":null,\"isLimitTime\":null,\"contentStartTime\":null,\"contentEndTime\":null,\"isLiveReplay\":0,\"isReplay\":0,\"replayResourceId\":null,\"submitStatus\":0,\"learnTotalTime\":0,\"studyProcess\":null,\"isLocked\":false,\"childItemList\":[{\"id\":10093,\"taskId\":null,\"courseId\":4059,\"refId\":null,\"type\":null,\"contentId\":null,\"status\":null,\"ownerId\":null,\"contentName\":\"节点1.1.1\",\"parentId\":10092,\"stageName\":null,\"sort\":null,\"isLimitTime\":null,\"contentStartTime\":null,\"contentEndTime\":null,\"isLiveReplay\":0,\"isReplay\":0,\"replayResourceId\":null,\"submitStatus\":0,\"learnTotalTime\":0,\"studyProcess\":null,\"isLocked\":false,\"childItemList\":[{\"id\":10094,\"taskId\":null,\"courseId\":4059,\"refId\":null,\"type\":null,\"contentId\":null,\"status\":null,\"ownerId\":null,\"contentName\":\"录音短片.mp4\",\"parentId\":10093,\"stageName\":null,\"sort\":null,\"isLimitTime\":null,\"contentStartTime\":null,\"contentEndTime\":null,\"isLiveReplay\":0,\"isReplay\":0,\"replayResourceId\":null,\"submitStatus\":0,\"learnTotalTime\":0,\"studyProcess\":null,\"isLocked\":false,\"childItemList\":null,\"isTraining\":0,\"isTrainingCanReserve\":null,\"isReserved\":null,\"trainingResult\":null,\"duration\":192,\"courseType\":1,\"lockCourseRate\":-1,\"detailId\":17774,\"studyInfo\":{\"courseItemId\":10094,\"playLength\":67,\"studyProcess\":2,\"learnRate\":100,\"studyProcessName\":\"\",\"lastPlay\":false},\"showTag\":null,\"homeworkId\":null,\"homeworkName\":null,\"liveStatus\":null,\"liveRoomId\":null},{\"id\":10095,\"taskId\":null,\"courseId\":4059,\"refId\":null,\"type\":null,\"contentId\":null,\"status\":null,\"ownerId\":null,\"contentName\":\"乌兰图雅-站在草原望北京(抖音DJ版原版).mp3\",\"parentId\":10093,\"stageName\":null,\"sort\":null,\"isLimitTime\":null,\"contentStartTime\":null,\"contentEndTime\":null,\"isLiveReplay\":0,\"isReplay\":0,\"replayResourceId\":null,\"submitStatus\":0,\"learnTotalTime\":0,\"studyProcess\":null,\"isLocked\":false,\"childItemList\":null,\"isTraining\":0,\"isTrainingCanReserve\":null,\"isReserved\":null,\"trainingResult\":null,\"duration\":279,\"courseType\":2,\"lockCourseRate\":-1,\"detailId\":17775,\"studyInfo\":{\"courseItemId\":10095,\"playLength\":182,\"studyProcess\":1,\"learnRate\":65,\"studyProcessName\":\"\",\"lastPlay\":true},\"showTag\":null,\"homeworkId\":null,\"homeworkName\":null,\"liveStatus\":null,\"liveRoomId\":null},{\"id\":10096,\"taskId\":null,\"courseId\":4059,\"refId\":null,\"type\":null,\"contentId\":null,\"status\":null,\"ownerId\":null,\"contentName\":\"安静小路.jpg\",\"parentId\":10093,\"stageName\":null,\"sort\":null,\"isLimitTime\":null,\"contentStartTime\":null,\"contentEndTime\":null,\"isLiveReplay\":0,\"isReplay\":0,\"replayResourceId\":null,\"submitStatus\":0,\"learnTotalTime\":0,\"studyProcess\":null,\"isLocked\":false,\"childItemList\":null,\"isTraining\":0,\"isTrainingCanReserve\":null,\"isReserved\":null,\"trainingResult\":null,\"duration\":0,\"courseType\":4,\"lockCourseRate\":-1,\"detailId\":17780,\"studyInfo\":{\"courseItemId\":10096,\"playLength\":1,\"studyProcess\":2,\"learnRate\":100,\"studyProcessName\":\"\",\"lastPlay\":false},\"showTag\":null,\"homeworkId\":null,\"homeworkName\":null,\"liveStatus\":null,\"liveRoomId\":null},{\"id\":10111,\"taskId\":null,\"courseId\":4059,\"refId\":null,\"type\":null,\"contentId\":null,\"status\":null,\"ownerId\":null,\"contentName\":\"研发中心-故障响应机制(1).pdf\",\"parentId\":10093,\"stageName\":null,\"sort\":null,\"isLimitTime\":null,\"contentStartTime\":null,\"contentEndTime\":null,\"isLiveReplay\":0,\"isReplay\":0,\"replayResourceId\":null,\"submitStatus\":0,\"learnTotalTime\":0,\"studyProcess\":null,\"isLocked\":false,\"childItemList\":null,\"isTraining\":0,\"isTrainingCanReserve\":null,\"isReserved\":null,\"trainingResult\":null,\"duration\":2,\"courseType\":3,\"lockCourseRate\":-1,\"detailId\":17778,\"studyInfo\":null,\"showTag\":null,\"homeworkId\":null,\"homeworkName\":null,\"liveStatus\":null,\"liveRoomId\":null}],\"isTraining\":0,\"isTrainingCanReserve\":null,\"isReserved\":null,\"trainingResult\":null,\"duration\":null,\"courseType\":0,\"lockCourseRate\":null,\"detailId\":null,\"studyInfo\":null,\"showTag\":null,\"homeworkId\":null,\"homeworkName\":null,\"liveStatus\":null,\"liveRoomId\":null}],\"isTraining\":0,\"isTrainingCanReserve\":null,\"isReserved\":null,\"trainingResult\":null,\"duration\":null,\"courseType\":0,\"lockCourseRate\":null,\"detailId\":null,\"studyInfo\":null,\"showTag\":null,\"homeworkId\":null,\"homeworkName\":null,\"liveStatus\":null,\"liveRoomId\":null}],\"isTraining\":0,\"isTrainingCanReserve\":null,\"isReserved\":null,\"trainingResult\":null,\"duration\":null,\"courseType\":0,\"lockCourseRate\":null,\"detailId\":null,\"studyInfo\":null,\"showTag\":null,\"homeworkId\":null,\"homeworkName\":null,\"liveStatus\":null,\"liveRoomId\":null}],\"isTraining\":0,\"isTrainingCanReserve\":null,\"isReserved\":null,\"trainingResult\":null,\"duration\":null,\"courseType\":null,\"lockCourseRate\":null,\"detailId\":null,\"studyInfo\":null,\"showTag\":null,\"homeworkId\":null,\"homeworkName\":null,\"liveStatus\":null,\"liveRoomId\":null},{\"id\":12006,\"taskId\":4361,\"courseId\":null,\"refId\":null,\"type\":4,\"contentId\":688,\"status\":2,\"ownerId\":165608,\"contentName\":\"测试app横竖屏\",\"parentId\":0,\"stageName\":null,\"sort\":3,\"isLimitTime\":null,\"contentStartTime\":\"2022-04-14 11:15:00\",\"contentEndTime\":\"2022-04-14 21:15:00\",\"isLiveReplay\":0,\"isReplay\":0,\"replayResourceId\":null,\"submitStatus\":0,\"learnTotalTime\":0,\"studyProcess\":null,\"isLocked\":null,\"childItemList\":[],\"isTraining\":0,\"isTrainingCanReserve\":null,\"isReserved\":null,\"trainingResult\":null,\"duration\":null,\"courseType\":null,\"lockCourseRate\":null,\"detailId\":null,\"studyInfo\":null,\"showTag\":null,\"homeworkId\":null,\"homeworkName\":null,\"liveStatus\":null,\"liveRoomId\":null}],\"courseUserDtoMap\":null,\"learningTotalTimeMap\":{\"4059\":1623},\"courseItemMap\":{\"4059\":[{\"id\":10091,\"parentId\":0,\"no\":1,\"name\":\"节点1\",\"type\":0,\"detailId\":null,\"duration\":null,\"courseId\":4059,\"showTag\":true,\"childrenList\":[{\"id\":10092,\"parentId\":10091,\"no\":1,\"name\":\"节点11\",\"type\":0,\"detailId\":null,\"duration\":null,\"courseId\":4059,\"showTag\":true,\"childrenList\":[{\"id\":10093,\"parentId\":10092,\"no\":1,\"name\":\"节点1.1.1\",\"type\":0,\"detailId\":null,\"duration\":null,\"courseId\":4059,\"showTag\":true,\"childrenList\":[{\"id\":10094,\"parentId\":10093,\"no\":1,\"name\":\"录音短片.mp4\",\"type\":1,\"detailId\":17774,\"duration\":192,\"courseId\":4059,\"showTag\":true,\"childrenList\":[],\"studyInfo\":{\"courseItemId\":10094,\"playLength\":67,\"studyProcess\":2,\"learnRate\":100,\"studyProcessName\":\"\",\"lastPlay\":false},\"resourceStartTime\":null,\"resourceEndTime\":null,\"dateExpireStatus\":1,\"dateExpireStatusName\":\"SAAS_COURSE_IN_EFFECT\",\"isLiveReplay\":null,\"isReplay\":null,\"liveStatus\":null,\"liveRoomId\":null,\"parentName\":null,\"lock\":false,\"lockCourseRate\":-1,\"resId\":17774},{\"id\":10095,\"parentId\":10093,\"no\":2,\"name\":\"乌兰图雅-站在草原望北京(抖音DJ版原版).mp3\",\"type\":2,\"detailId\":17775,\"duration\":279,\"courseId\":4059,\"showTag\":true,\"childrenList\":[],\"studyInfo\":{\"courseItemId\":10095,\"playLength\":182,\"studyProcess\":1,\"learnRate\":65,\"studyProcessName\":\"\",\"lastPlay\":true},\"resourceStartTime\":null,\"resourceEndTime\":null,\"dateExpireStatus\":1,\"dateExpireStatusName\":\"SAAS_COURSE_IN_EFFECT\",\"isLiveReplay\":null,\"isReplay\":null,\"liveStatus\":null,\"liveRoomId\":null,\"parentName\":null,\"lock\":false,\"lockCourseRate\":-1,\"resId\":17775},{\"id\":10096,\"parentId\":10093,\"no\":3,\"name\":\"安静小路.jpg\",\"type\":4,\"detailId\":17780,\"duration\":0,\"courseId\":4059,\"showTag\":true,\"childrenList\":[],\"studyInfo\":{\"courseItemId\":10096,\"playLength\":1,\"studyProcess\":2,\"learnRate\":100,\"studyProcessName\":\"\",\"lastPlay\":false},\"resourceStartTime\":null,\"resourceEndTime\":null,\"dateExpireStatus\":1,\"dateExpireStatusName\":\"SAAS_COURSE_IN_EFFECT\",\"isLiveReplay\":null,\"isReplay\":null,\"liveStatus\":null,\"liveRoomId\":null,\"parentName\":null,\"lock\":false,\"lockCourseRate\":-1,\"resId\":17780},{\"id\":10111,\"parentId\":10093,\"no\":4,\"name\":\"研发中心-故障响应机制(1).pdf\",\"type\":3,\"detailId\":17778,\"duration\":2,\"courseId\":4059,\"showTag\":true,\"childrenList\":[],\"studyInfo\":null,\"resourceStartTime\":null,\"resourceEndTime\":null,\"dateExpireStatus\":1,\"dateExpireStatusName\":\"SAAS_COURSE_IN_EFFECT\",\"isLiveReplay\":null,\"isReplay\":null,\"liveStatus\":null,\"liveRoomId\":null,\"parentName\":null,\"lock\":false,\"lockCourseRate\":-1,\"resId\":17778}],\"studyInfo\":null,\"resourceStartTime\":null,\"resourceEndTime\":null,\"dateExpireStatus\":1,\"dateExpireStatusName\":\"SAAS_COURSE_IN_EFFECT\",\"isLiveReplay\":null,\"isReplay\":null,\"liveStatus\":null,\"liveRoomId\":null,\"parentName\":null,\"lock\":false,\"lockCourseRate\":null,\"resId\":null}],\"studyInfo\":null,\"resourceStartTime\":null,\"resourceEndTime\":null,\"dateExpireStatus\":1,\"dateExpireStatusName\":\"SAAS_COURSE_IN_EFFECT\",\"isLiveReplay\":null,\"isReplay\":null,\"liveStatus\":null,\"liveRoomId\":null,\"parentName\":null,\"lock\":false,\"lockCourseRate\":null,\"resId\":null}],\"studyInfo\":null,\"resourceStartTime\":null,\"resourceEndTime\":null,\"dateExpireStatus\":1,\"dateExpireStatusName\":\"SAAS_COURSE_IN_EFFECT\",\"isLiveReplay\":null,\"isReplay\":null,\"liveStatus\":null,\"liveRoomId\":null,\"parentName\":null,\"lock\":false,\"lockCourseRate\":null,\"resId\":null}]},\"homeworkMap\":null,\"task\":{\"id\":4361,\"name\":\"培训任务040801\",\"coverUrl\":\"https://hrss-pro.oss-cn-beijing.aliyuncs.com/hrss/image/4a9362780a2244a2be2e92baddced4aa-村外.jpg\",\"cycleType\":3,\"applyStartTime\":null,\"applyEndTime\":null,\"startTime\":null,\"endTime\":null,\"referId\":null,\"status\":2,\"statusList\":null,\"isDel\":0,\"isConfigCert\":1,\"isAddOfflinTranining\":0,\"finishDays\":0,\"createUserId\":165608,\"createTime\":\"2022-04-08 14:18:05\",\"updateUserId\":165608,\"updateTime\":\"2022-04-14 11:05:08\",\"branchId\":5826,\"saasId\":174,\"description\":\"<p>培训任务介绍</p >\",\"addUserTime\":null,\"lastVisitTime\":null,\"ids\":null,\"referIdList\":null,\"vocationCode\":\"4-10-01-02-98-02\",\"trainingMethod\":\"1,3,5\",\"vocationCodes\":null,\"outIds\":null,\"copySource\":null},\"taskItemTypeList\":[{\"type\":2,\"count\":1},{\"type\":4,\"count\":1}],\"vocation\":null,\"workType\":null,\"skillLevel\":null,\"trainingMethod\":\"1,3,5\",\"branchId\":5703,\"userBranchId\":5826,\"itemInfos\":null},\"success\":true}"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_list_layout)
        val testData = Gson().fromJson(data, TestData::class.java)
        val listView = findViewById<RecyclerView>(R.id.test_list)
        listView.addItemDecoration(VDividerItemDecoration(this))
        listView.adapter = ListAdapter(testData.data.taskItemVoList)
    }
}