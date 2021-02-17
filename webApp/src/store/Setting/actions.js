export default {
  authUserAction (context, payload) {
    context.commit('authUserCommit', payload)
  },
  addUserAction (context, payload) {
    context.commit('addUserCommit', payload)
  },
  activePageAction (context, payload) {
    context.commit('activePageCommit', payload)
  },
  setLangAction (context, payload) {
    context.commit('setLangCommit', payload)
  },
  layoutModeAction (context, payload) {
    let dark = payload.dark ? 'dark' : 'light'
    let rtl = payload.rtl ? 'rtl' : 'ltr'
    document.getElementsByTagName('html')[0].setAttribute('mode', dark)
    document.getElementsByTagName('html')[0].setAttribute('dir', rtl)
    context.commit('layoutModeCommit', {
      dark: payload.dark,
      rtl: payload.rtl,
      sidebar: ''
    })
  }
}
