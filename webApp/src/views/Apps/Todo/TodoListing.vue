<template>
    <b-row>
      <b-col lg="3">
        <ProjectList
          :project-list="projectList"
          :category-list="categoryList"
          :selected-category="selectedCategory"
          :selected-project="selectedProject"/>
      </b-col>
      <b-col lg="9">
        <TaskList :task-list="taskList" :project="selectedProject" :category="selectedCategory"/>
      </b-col>
    </b-row>
</template>
<script>
import { socialvue } from '../../../config/pluginInit'
import ProjectList from '../Todo/ProjectList'
import TaskList from '../Todo/TaskList'
import { mapGetters } from 'vuex'
import Todo from '../../../store/Todo'
export default {
  name: 'TodoListing',
  components: { ProjectList, TaskList },
  mounted () {
    socialvue.index()
  },
  beforeMount () {
    this.$store.registerModule('Todo', Todo)
  },
  beforeDestroy () {
    this.$store.unregisterModule('Todo')
  },
  computed: {
    ...mapGetters({
      taskList: 'Todo/taskState',
      projectList: 'Todo/projectState',
      categoryList: 'Todo/categoryState',
      selectedCategory: 'Todo/selectedCategoryState',
      selectedProject: 'Todo/selectedProjectState'
    })
  }
}
</script>
<style>
</style>
