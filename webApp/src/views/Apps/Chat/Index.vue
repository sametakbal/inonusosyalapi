<template>
    <b-row>
      <b-col>
        <iq-card body-class="chat-page p-0">
          <template v-slot:body>
            <div class="chat-data-block">
              <b-row>
                <b-col lg="3" class="chat-data-left scroller">
                  <div class="chat-search pt-3 pl-3">
                    <ToggleButton toggleShow="#user-detail-popup">
                      <template v-slot:media>
                        <img :src="user.image" alt="chat-user" class="avatar-60 ">
                      </template>
                      <template v-slot:body>
                        <h5 class="mb-0">{{ user.name }}</h5>
                        <p class="m-0">{{ user.role }}</p>
                      </template>
                    </ToggleButton>
                    <ToggleContent id="user-detail-popup" body-class="text-left">
                      <template v-slot:media>
                        <img :src="user.image" alt="avatar">
                      </template>
                      <template v-slot:title>
                        <div class="user-name mt-4"><h4>{{ user.name }}</h4></div>
                          <div class="user-desc"><p>{{ user.role }}</p></div>
                      </template>
                      <template v-slot:body>
                        <h5 class="mt-4 mb-4">About</h5>
                          <p>It is long established fact that a reader will be distracted bt the reddable.</p>
                          <h5 class="mt-3 mb-3">Status</h5>
                          <ul class="user-status p-0">
                            <li class="mb-1"><i class="ri-checkbox-blank-circle-fill text-success pr-1"></i><span>Online</span></li>
                            <li class="mb-1"><i class="ri-checkbox-blank-circle-fill text-warning pr-1"></i><span>Away</span></li>
                            <li class="mb-1"><i class="ri-checkbox-blank-circle-fill text-danger pr-1"></i><span>Do Not Disturb</span></li>
                            <li class="mb-1"><i class="ri-checkbox-blank-circle-fill text-light pr-1"></i><span>Offline</span></li>
                          </ul>
                      </template>
                    </ToggleContent>
                    <div class="chat-searchbar mt-4">
                      <div class="form-group chat-search-data m-0">
                        <input type="text" class="form-control round" id="chat-search" placeholder="Search" v-model="search">
                        <i class="ri-search-line" />
                      </div>
                    </div>
                  </div>
                  <div class="chat-sidebar-channel scroller mt-4 pl-3">
                    <h5>Private Channel</h5>
                    <tab-nav :pills="true" :vertical="true" class="iq-chat-ui" id="chat-list-data">
                      <template v-for="(item,index) in privateList">
                        <tab-nav-items :key="index"
                                       :id="`v-pills-${item.id}`"
                                       href="#v-pills-home"
                                       :ariaControls="`v-pills-${item.id}`"
                                       role="tab">
                          <template v-slot:title>
                            <ChatItem :item="item" />
                          </template>
                        </tab-nav-items>
                      </template>
                    </tab-nav>
                    <h5>Public Channel</h5>
                    <tab-nav :pills="true" :vertical="true" class="iq-chat-ui" id="chat-list-data">
                      <template v-for="(item,index) in publicList">
                        <tab-nav-items :key="index"
                                       :id="`v-pills-${item.id}`"
                                       href="#v-pills-home"
                                       :ariaControls="`v-pills-${item.id}`"
                                       role="tab">
                          <template v-slot:title>
                            <ChatItem :item="item" />
                          </template>
                        </tab-nav-items>
                      </template>
                    </tab-nav>
                  </div>
                </b-col>

                <div class="col-lg-9 chat-data p-0 chat-data-right" :style="`background: url(${require('../../../assets/images/page-img/100.jpg')}) no-repeat scroll center center;background-size: cover;`">
                  <tab-content id="v-pills-tabContent">
                    <tab-content-item :active="true" id="v-pills-default" aria-labelled-by="v-pills-default">
                      <template>
                        <ToggleButton :mini-toggle="true" :close-button="false" toggleShow="#chat-user-detail-popup" mediaClass="chat-user-profile">
                          <template v-slot:media>
                          </template>
                          <template v-slot:body>
                          </template>
                        </ToggleButton>
                        <div class="chat-start">
                          <div class="chat-start">
                            <span class="iq-start-icon text-primary"><i class="ri-message-3-line"></i></span>
                            <button id="chat-start" class="btn bg-white mt-3">Start
                              Conversation!</button>
                          </div>
                        </div>
                      </template>
                    </tab-content-item>
                    <tab-content-item id="v-pills-home" aria-labelled-by="v-pills-default">
                      <template>
                        <div class="chat-head">
                          <header class="d-flex justify-content-between align-items-center bg-white pt-3 pr-3 pb-3">
                            <ToggleButton :mini-toggle="true" :close-button="false" toggleShow="#chat-user-detail-popup" mediaClass="chat-user-profile">
                              <template v-slot:media>
                                  <img :src="checkUser(5, 'image')" alt="avatar" class="avatar-50 ">
                                  <span class="avatar-status"><i class="ri-checkbox-blank-circle-fill text-success" /></span>
                              </template>
                              <template v-slot:body>
                                <h5 class="mb-0">{{ checkUser(5, 'name') }}</h5>
                              </template>
                            </ToggleButton>
                            <ToggleContent id="chat-user-detail-popup" bodyClass="chatuser-detail" center>
                              <template v-slot:media>
                                <img :src="checkUser(5,'image')" alt="avatar">
                              </template>
                              <template v-slot:title>
                                <div class="user-name mt-4"><h4>{{ checkUser(5, 'name') }}</h4></div>
                                <div class="user-desc"><p>Cape Town, RSA</p></div>
                              </template>
                              <template v-slot:body>
                                <div class="row">
                                  <div class="col-6 col-md-6 title">Nik Name:</div>
                                  <div class="col-6 col-md-6 text-right">{{ checkUser(5, 'name') }}</div>
                                </div><hr>
                                <div class="row">
                                  <div class="col-6 col-md-6 title">Tel:</div>
                                  <div class="col-6 col-md-6 text-right">072 143 9920</div>
                                </div><hr>
                                <div class="row">
                                  <div class="col-6 col-md-6 title">Date Of Birth:</div>
                                  <div class="col-6 col-md-6 text-right">July 12, 1989</div>
                                </div><hr>
                                <div class="row">
                                  <div class="col-6 col-md-6 title">Gender:</div>
                                  <div class="col-6 col-md-6 text-right">Male</div>
                                </div><hr>
                                <div class="row">
                                  <div class="col-6 col-md-6 title">Language:</div>
                                  <div class="col-6 col-md-6 text-right">Engliah</div>
                                </div>
                              </template>
                            </ToggleContent>
                            <div class="chat-header-icons d-flex">
                              <a class="iq-bg-primary iq-waves-effect mr-1 chat-icon-phone"><i class="ri-phone-line mr-0" /></a>
                              <a class="iq-bg-primary iq-waves-effect mr-1 chat-icon-video"><i class="ri-vidicon-line  mr-0" /></a>
                              <a class="iq-bg-primary iq-waves-effect mr-1 chat-icon-delete"><i class="ri-delete-bin-line  mr-0" /></a>
                              <b-dropdown id="dropdownMenuButton2" right variant="none iq-bg-primary iq-waves-effect remove-toggle">
                                <template v-slot:button-content>
                                  <i class="ri-more-2-line mr-0" />
                                </template>
                                <b-dropdown-item href="#"><i class="fa fa-thumb-tack mr-0" aria-hidden="true"></i> Pin to top</b-dropdown-item>
                                <b-dropdown-item href="#"><i class="fa fa-trash-o mr-0" aria-hidden="true"></i> Delete chat</b-dropdown-item>
                                <b-dropdown-item href="#"><i class="fa fa-ban mr-0" aria-hidden="true"></i> Block</b-dropdown-item>
                              </b-dropdown>
                            </div>
                          </header>
                        </div>
                        <div class="chat-content scroller">
                          <template v-for="(item,index) in chat">
                            <div class="chat" :key="index" v-if="!item.me">
                              <div class="chat-user">
                                <a class="avatar m-0">
                                  <img :src="checkUser(item.userId, 'image')" alt="avatar" class="avatar-35 " />
                                </a>
                                <span class="chat-time mt-1">{{ item.time }}</span>
                              </div>
                              <div class="chat-detail">
                                <div class="chat-message">
                                  <p>{{ item.text }}</p>
                                </div>
                              </div>
                            </div>
                            <div class="chat chat-left" :key="index" v-else>
                              <div class="chat-user">
                                <a class="avatar m-0">
                                  <img :src="checkUser(item.userId,'image')" alt="avatar" class="avatar-35 " />
                                </a>
                                <span class="chat-time mt-1">{{ item.time }}</span>
                              </div>
                              <div class="chat-detail">
                                <div class="chat-message">
                                  <p>{{ item.text }}</p>
                                </div>
                              </div>
                            </div>
                          </template>
                        </div>
                        <div class="chat-footer p-3 bg-white">
                          <form class="d-flex align-items-center"  action="javascript:void(0);">
                            <div class="chat-attagement d-flex">
                              <a href="javascript:void(0)"><i class="fa fa-smile-o pr-3" aria-hidden="true"></i></a>
                              <a href="javascript:void(0)"><i class="fa fa-paperclip pr-3" aria-hidden="true"></i></a>
                            </div>
                            <input type="text" class="form-control mr-3" placeholder="Type your message">
                            <button type="submit" class="btn btn-primary d-flex align-items-center p-2"><i class="far fa-paper-plane"></i><span class="d-none d-lg-block ml-1">Send</span></button>
                          </form>
                        </div>
                      </template>
                    </tab-content-item>
                  </tab-content>
                </div>
              </b-row>
            </div>
          </template>
        </iq-card>
      </b-col>
    </b-row>
</template>
<script>
import { socialvue } from '../../../config/pluginInit'
import ChatItem from '../../../components/Chat/ChatItem'
import ToggleButton from '../../../components/Chat/ToggleButton'
import ToggleContent from '../../../components/Chat/ToggleContent'
import { Users, MessagesUser1 } from '../../../FackApi/api/chat'
import User from '../../../Model/User'

export default {
  name: 'Index',
  components: { ChatItem, ToggleButton, ToggleContent },
  mounted () {
    socialvue.index()
  },
  computed: {
    filteredList () {
      return this.usersList.filter(item => {
        return item.name.toLowerCase().includes(this.search.toLowerCase())
      })
    },
    publicList () {
      return this.usersList.filter(item => {
        return !item.isPrivate ? item.name.toLowerCase().includes(this.search.toLowerCase()) : false
      })
    },
    privateList () {
      return this.usersList.filter(item => {
        return item.isPrivate ? item.name.toLowerCase().includes(this.search.toLowerCase()) : false
      })
    }
  },
  data () {
    return {
      search: '',
      user: new User({ id: 1, name: 'Anna Sthesia', role: 'Developer', image: require('../../../assets/images/user/user-08.jpg'), isActive: true }),
      usersList: Users,
      chat: MessagesUser1
    }
  },
  methods: {
    checkUser (item, type) {
      let user = this.usersList.find(user => user.id === item)
      let final
      if (user !== undefined) {
        switch (type) {
          case 'name':
            final = user.name
            break
          case 'image':
            final = user.image
            break
          case 'role':
            final = user.role
            break
        }
        return final
      }
      return require('../../../assets/images/user/user-05.jpg')
    }
  }
}
</script>
<style>
  .remove-toggle::after{
    content: unset;
  }
</style>
