import getters from './getters'
import actions from './actions'
import mutations from './mutations'

const state = {
  categoryList: [
    {
      id: 1,
      name: 'All Task',
      color: 'success',
      isHidden: true
    },
    {
      id: 2,
      name: 'People',
      color: 'warning',
      isHidden: false
    },
    {
      id: 3,
      name: 'Files',
      color: 'danger',
      isHidden: false
    },
    {
      id: 4,
      name: 'Statistics',
      color: 'primary',
      isHidden: false
    }
  ],
  projectList: [
    {
      id: 1,
      project_name: 'Analytics'
    },
    {
      id: 2,
      project_name: 'Project Management'
    },
    {
      id: 3,
      project_name: 'E-commerce'
    },
    {
      id: 4,
      project_name: 'CRM'
    }
  ],
  taskList: [
    {
      id: 1,
      task_title: 'Landing page for secret',
      project_id: 1,
      category_id: 1,
      user_id: 1,
      status: 'Expiring',
      task_status: false
    },
    {
      id: 1,
      task_title: 'Landing page for secret',
      project_id: 1,
      category_id: 1,
      user_id: 4,
      status: 'Expiring',
      task_status: false
    },
    {
      id: 1,
      task_title: 'Landing page for secret',
      project_id: 1,
      category_id: 1,
      user_id: 3,
      status: 'Complete',
      task_status: true
    },
    {
      id: 1,
      task_title: 'Landing page for secret',
      project_id: 1,
      category_id: 1,
      user_id: 5,
      status: 'Expiring',
      task_status: false
    },
    {
      id: 2,
      task_title: 'Dashboard page',
      project_id: 1,
      category_id: 4,
      user_id: 2,
      status: 'Complete',
      task_status: true
    },
    {
      id: 1,
      task_title: 'Project 1 Landing page for secret Project',
      project_id: 2,
      category_id: 3,
      user_id: 1,
      status: 'Expiring',
      task_status: true
    },
    {
      id: 2,
      task_title: 'Project 1 Dashboard page',
      project_id: 2,
      category_id: 2,
      user_id: 2,
      status: 'Complete',
      task_status: false
    }
  ],
  selectedProject: {
    id: 1,
    project_name: 'Analytics'
  },
  selectedCategory: {
    id: 1,
    name: 'All Task',
    color: 'success',
    isHidden: true
  }
}

export default {
  namespaced: true,
  state,
  getters,
  actions,
  mutations
}
