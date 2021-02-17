export default {
  addProjectAction (context, payload) {
    return new Promise((resolve, reject) => {
      context.commit('addProjectCommit', payload)
      resolve()
    })
  },
  addTaskAction (context, payload) {
    return new Promise((resolve, reject) => {
      context.commit('addTaskCommit', payload)
      resolve()
    })
  },
  selectedAction (context, payload) {
    return new Promise((resolve, reject) => {
      context.commit('selectedCommit', payload)
      resolve()
    })
  },
  updateStatusAction (context, payload) {
    return new Promise((resolve, reject) => {
      context.commit('updateStatusCommit', payload)
      resolve()
    })
  }
}
