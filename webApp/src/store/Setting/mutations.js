export default {
  activePageCommit (state, data) {
    state.activePage = data
  },
  setLangCommit (state, data) {
    state.lang = data
  },
  layoutModeCommit (state, data) {
    state.layoutMode = data
  }
}
