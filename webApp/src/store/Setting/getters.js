export default {
  authUserState: state => state.authUser,
  usersState: state => state.users,
  activePage: state => state.activePage,
  langState: state => state.lang,
  langOptionState: state => state.langOption,
  darkModeState: state => state.layoutMode.dark,
  rtlModeState: state => state.layoutMode.rtl
}
