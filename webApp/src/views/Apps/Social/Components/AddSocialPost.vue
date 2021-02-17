<template>
  <div >
    <iq-card  id="post-modal-data" body-class="iq-card iq-card-block iq-card-stretch iq-card-height" >
      <template v-slot:headerTitle >
        <h4 class="card-title">Create Post</h4>
      </template>
      <div class="iq-card-body" v-b-modal.modal1>
        <div class="d-flex align-items-center">
            <div class="user-img">
            <img class="avatar-60 rounded-circle" src="../../../../assets/images/user/user-01.jpg">
            </div>
            <form  class="post-text ml-3 w-100">
            <input type="text" placeholder="Write something about post..." class="rounded form-control" v-model="post.description" style="border:none;" />
            </form>
        </div>
        <hr />
         <ul class="post-opt-block d-flex align-items-center list-inline m-0 p-0">
            <li class="iq-bg-primary rounded p-2 pointer mr-3"><a href="#"></a><img src="../../../../assets/images/small/07.png" alt="icon" class="img-fluid"> Photo/Video</li>
            <li class="iq-bg-primary rounded p-2 pointer mr-3"><a href="#"></a><img src="../../../../assets/images/small/08.png" alt="icon" class="img-fluid"> Tag Friend</li>
            <li class="iq-bg-primary rounded p-2 pointer mr-3"><a href="#"></a><img src="../../../../assets/images/small/09.png" alt="icon" class="img-fluid"> Feeling/Activity</li>
            <li class="iq-bg-primary rounded p-2 pointer">
              <div class="iq-card-header-toolbar d-flex align-items-center">
                  <div class="dropdown">
                    <span class="dropdown-toggle" id="post-option" data-toggle="dropdown" >
                    <i class="ri-more-fill"></i>
                    </span>
                    <div class="dropdown-menu dropdown-menu-right" aria-labelledby="post-option" style="">
                        <a class="dropdown-item" href="#">Check in</a>
                        <a class="dropdown-item" href="#">Live Video</a>
                        <a class="dropdown-item" href="#">Gif</a>
                        <a class="dropdown-item" href="#">Watch Party</a>
                        <a class="dropdown-item" href="#">Play with Friend</a>
                    </div>
                  </div>
              </div>
            </li>
        </ul>
      </div>
      <b-modal id="modal1" centered title="Create Post" hide-footer>
          <div class="d-flex align-items-center">
            <div class="user-img">
                <img src="../../../../assets/images/user/1.jpg" alt="userimg" class="avatar-60 rounded-circle img-fluid">
            </div>
            <form  class="post-text ml-3 w-100">
              <input type="text" placeholder="Write something about post..." class="rounded form-control" v-model="post.description" style="border:none;" />
            </form>
          </div>
        <hr />
        <ul class="d-flex flex-wrap align-items-center list-inline m-0 p-0">
          <li class="col-md-6 mb-3" v-for="(item,index) in tab" :key="index">
            <div class="iq-bg-primary rounded p-2 pointer mr-3">
              <a href="#"></a><img :src="item.icon" alt="icon" class="img-fluid">
              {{item.name}}
            </div>
          </li>
        </ul>
        <div class="other-option">
          <div class="d-flex align-items-center justify-content-between">
            <div class="d-flex align-items-center">
              <div class="user-img mr-3">
                <img src="../../../../assets/images/user/1.jpg" alt="userimg" class="avatar-60 rounded-circle img-fluid">
              </div>
              <h6>Your Story</h6>
            </div>
            <div class="iq-card-post-toolbar">
            <b-dropdown id="dropdownMenuButton40" right variant="none" menu-class="p-0">
              <template v-slot:button-content>
                <button href="#" class="dropdown-toggle btn btn-primary">Friends</button>
              </template>
              <b-dropdown-item href="#" class="dropdown-item p-3">
                <div class="d-flex align-items-top">
                  <div class="d-flex align-items-top"><i class="ri-save-line"></i></div>
                  <div class="data ml-2">
                    <h6>Public</h6>
                    <p class="mb-0">Anyone on or off Facebook</p>
                  </div>
                </div>
              </b-dropdown-item>
              <b-dropdown-item href="#" class="dropdown-item p-3">
                <div class="d-flex align-items-top">
                  <div class="d-flex align-items-top"><i class="ri-close-circle-line"></i></div>
                  <div class="data ml-2">
                    <h6>Friends</h6>
                    <p class="mb-0">Your friend on facebook</p>
                  </div>
                </div>
              </b-dropdown-item>
              <b-dropdown-item href="#" class="dropdown-item p-3">
                <div class="d-flex align-items-top">
                  <div class="d-flex align-items-top"><i class="ri-user-unfollow-line"></i></div>
                  <div class="data ml-2">
                    <h6>Friend expect</h6>
                    <p class="mb-0">Dont show to some friend</p>
                  </div>
                </div>
              </b-dropdown-item>
              <b-dropdown-item href="#" class="dropdown-item p-3">
                <div class="d-flex align-items-top">
                  <div class="d-flex align-items-top"><i class="ri-notification-line"></i></div>
                  <div class="data ml-2">
                    <h6>Only me</h6>
                    <p class="mb-0">Only me</p>
                  </div>
                </div>
              </b-dropdown-item>
            </b-dropdown>
            </div>
          </div>
        </div>
        <button class="btn btn-primary d-block w-100 mt-3" @click="addNewPost(post)">Post</button>
      </b-modal>
    </iq-card>
  </div>
</template>
<script>
import Post from '../../../../Model/Post'
export default {
  name: 'AddSocialPost',
  data () {
    return {
      post: new Post(),
      tab: [
        {
          icon: require('../../../../assets/images/small/07.png'),
          name: ' Photo/Video'
        },
        {
          icon: require('../../../../assets/images/small/08.png'),
          name: ' Tag Friend'
        },
        {
          icon: require('../../../../assets/images/small/09.png'),
          name: 'Feeling/Activity'
        },
        {
          icon: require('../../../../assets/images/small/10.png'),
          name: 'Check in'
        },
        {
          icon: require('../../../../assets/images/small/11.png'),
          name: 'Live Video'
        },
        {
          icon: require('../../../../assets/images/small/12.png'),
          name: ' Gif'
        },
        {
          icon: require('../../../../assets/images/small/13.png'),
          name: 'Watch Party'
        },
        {
          icon: require('../../../../assets/images/small/14.png'),
          name: ' Play with Friends'
        }
      ]
    }
  },
  methods: {
    addNewPost (post) {
      this.$emit('addPost', post)
      this.post = new Post()
      this.$bvModal.hide('modal1')
    },
    resetPost () {
      this.post = new Post()
    },
    previewImage: function (event) {
      const files = event.target.files
      Object.keys(files).forEach(i => {
        const file = files[i]
        const reader = new FileReader()
        reader.onload = (e) => {
          this.post.images.push(e.target.result)
        }
        reader.readAsDataURL(file)
      })
    }
  }
}
</script>
