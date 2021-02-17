import getters from './getters'
import actions from './actions'
import mutations from './mutations'

const state = {
  lang: { title: 'English', value: 'en', image: require('../../assets/images/small/flag-01.png') },
  langOption: [
    { title: 'English', value: 'en', image: require('../../assets/images/small/flag-01.png') },
    { title: 'Arabic', value: 'ar', image: require('../../assets/images/small/flag-500.png') },
    { title: 'Chinese', value: 'chi', image: require('../../assets/images/small/flag-300.png') },
    { title: 'Hindi', value: 'hi', image: require('../../assets/images/small/flag-100.png') },
    { title: 'Greek', value: 'gr', image: require('../../assets/images/small/flag-400.png') },
    { title: 'Franch', value: 'fr', image: require('../../assets/images/small/flag-200.png') }
  ],
  users: [
    {
      id: 'sh46s546sdg564sdffs4hsd6fh',
      name: 'Admin SocialV',
      mobileNo: null,
      email: 'admin@socialvue.com',
      profileImage: null,
      password: 'admin123'
    }
  ],
  activePage: {
    name: 'Dashboard',
    breadCrumb: [
      {
        html: '<i class="ri-home-4-line mr-1 float-left"></i>Home',
        to: { name: 'mini.dashboard.home-1' }
      },
      {
        text: '',
        href: '#'
      }
    ]
  },
  layoutMode: {
    dark: false,
    rtl: false
  }
}

export default {
  namespaced: true,
  state,
  getters,
  actions,
  mutations
}
