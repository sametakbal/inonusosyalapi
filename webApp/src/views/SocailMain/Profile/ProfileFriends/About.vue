<template>
    <div class="row">
      <div class="col-md-3">
        <tab-nav :pills="true" id="tab" class="nav nav-pills basic-info-items list-inline d-block p-0 m-0" >
          <tab-nav-items :active="true" id="pills-contact-info" href="#contact-info" ariaControls="pills-contact-info" role="tab" :ariaSelected="true" title="Contact and Basic Info" />
          <tab-nav-items :active="false" id="pills-family-info" href="#family-info" ariaControls="pills-family-info" role="tab" :ariaSelected="true" title="Family and Relationship" />
          <tab-nav-items :active="false" id="pills-work-info" href="#work-info" ariaControls="pills-work-info" role="tab" :ariaSelected="true" title="Work and Education" />
          <tab-nav-items :active="false" id="pills-address-info" href="#address-info" ariaControls="pills-address-info" role="tab" :ariaSelected="true" title="Places You've Lived" />
          <tab-nav-items :active="false" id="pills-about-info" href="#about-info" ariaControls="pills-about-info" role="tab" :ariaSelected="true" title="Details About You" />
        </tab-nav>
      </div>
      <div class="col-md-9">
        <div class="tab-content">
          <tab-content-item :active="true" id="contact-info" aria-labelled-by="pills-contact-info">
            <h4>Contact Information</h4>
            <hr>
            <div class="row">
              <div class="col-3">
                <h6>Email</h6>
              </div>
              <div class="col-9">
                <p class="mb-0">Bnijohn@gmail.com</p>
              </div>
              <div class="col-3">
                <h6>Mobile</h6>
              </div>
              <div class="col-9">
                <p class="mb-0">(001) 4544 565 456</p>
              </div>
              <div class="col-3">
                <h6>Address</h6>
              </div>
              <div class="col-9">
                <p class="mb-0">United States of America</p>
              </div>
            </div>
            <h4 class="mt-3">Websites and Social Links</h4>
            <hr>
            <div class="row">
              <div class="col-3">
                <h6>Website</h6>
              </div>
              <div class="col-9">
                <p class="mb-0">www.bootstrap.com</p>
              </div>
              <div class="col-3">
                <h6>Social Link</h6>
              </div>
              <div class="col-9">
                <p class="mb-0">www.bootstrap.com</p>
              </div>
            </div>
            <h4 class="mt-3">Basic Information</h4>
            <hr>
            <div class="row">
              <div class="col-3">
                <h6>Birth Date</h6>
              </div>
              <div class="col-9">
                <p class="mb-0">24 January</p>
              </div>
              <div class="col-3">
                <h6>Birth Year</h6>
              </div>
              <div class="col-9">
                <p class="mb-0">1994</p>
              </div>
              <div class="col-3">
                <h6>Gender</h6>
              </div>
              <div class="col-9">
                <p class="mb-0">Female</p>
              </div>
              <div class="col-3">
                <h6>interested in</h6>
              </div>
              <div class="col-9">
                <p class="mb-0">Designing</p>
              </div>
              <div class="col-3">
                <h6>language</h6>
              </div>
              <div class="col-9">
                <p class="mb-0">English, French</p>
              </div>
            </div>
          </tab-content-item>
          <tab-content-item :active="false" id="family-info" aria-labelled-by="pills-family-info">
            <h4 class="mb-3">Relationship</h4>
            <ul class="suggestions-lists m-0 p-0">
              <li class="d-flex mb-4 align-items-center">
                <div class="user-img img-fluid"><i class="ri-add-fill"></i></div>
                <div class="media-support-info ml-3">
                  <h6>Add Your Relationship Status</h6>
                </div>
              </li>
            </ul>
            <h4 class="mt-3 mb-3">Family Members</h4>
            <ul class="suggestions-lists m-0 p-0">
              <li class="d-flex mb-4 align-items-center">
                <div class="user-img img-fluid"><i class="ri-add-fill"></i></div>
                <div class="media-support-info ml-3">
                  <h6>Add Family Members</h6>
                </div>
              </li>
              <li class="d-flex mb-4 align-items-center" v-for="(item,index) in friend" :key="index">
                <div class="user-img img-fluid"><img :src="item.img" alt="story-img" class="rounded-circle avatar-40"></div>
                <div class="media-support-info ml-3">
                  <h6>{{item.name}}</h6>
                  <p class="mb-0">{{item.realtion}}</p>
                </div>
                <div class="edit-relation"><a href="#"><i class="ri-edit-line mr-2"></i>Edit</a></div>
              </li>
            </ul>
          </tab-content-item>
          <tab-content-item :active="false" id="work-info" aria-labelled-by="pills-work-info">
            <h4 class="mb-3">Work</h4>
            <ul class="suggestions-lists m-0 p-0">
              <li class="d-flex mb-4 align-items-center">
                <div class="user-img img-fluid"><i class="ri-add-fill"></i></div>
                <div class="media-support-info ml-3">
                  <h6>Add Work Place</h6>
                </div>
              </li>
              <li class="d-flex mb-4 align-items-center" v-for="(work,index) in work" :key="index">
                <div class="user-img img-fluid"><img :src="work.img" alt="story-img" class="rounded-circle avatar-40"></div>
                <div class="media-support-info ml-3">
                  <h6>{{work.name}}</h6>
                  <p class="mb-0">{{work.dec}}</p>
                </div>
                <div class="edit-relation"><a href="javascript:void();"><i class="ri-edit-line mr-2"></i>Edit</a></div>
              </li>
            </ul>
            <h4 class="mb-3">Professional Skills</h4>
            <ul class="suggestions-lists m-0 p-0">
              <li class="d-flex mb-4 align-items-center">
                <div class="user-img img-fluid"><i class="ri-add-fill"></i></div>
                <div class="media-support-info ml-3">
                  <h6>Add Professional Skills</h6>
                </div>
              </li>
            </ul>
            <h4 class="mt-3 mb-3">College</h4>
            <ul class="suggestions-lists m-0 p-0">
              <li class="d-flex mb-4 align-items-center">
                <div class="user-img img-fluid"><i class="ri-add-fill"></i></div>
                <div class="media-support-info ml-3">
                  <h6>Add College</h6>
                </div>
              </li>
              <li class="d-flex mb-4 align-items-center">
                <div class="user-img img-fluid"><img src="../../../../assets/images/user/01.jpg" alt="story-img" class="rounded-circle avatar-40"></div>
                <div class="media-support-info ml-3">
                  <h6>Lorem ipsum</h6>
                  <p class="mb-0">USA</p>
                </div>
                <div class="edit-relation"><a href="#"><i class="ri-edit-line mr-2"></i>Edit</a></div>
              </li>
            </ul>
          </tab-content-item>
          <tab-content-item :active="false" id="address-info" aria-labelled-by="pills-address-info">
            <h4 class="mb-3">Current City and Hometown</h4>
            <ul class="suggestions-lists m-0 p-0">
              <li class="d-flex mb-4 align-items-center">
                <div class="user-img img-fluid"><img src="../../../../assets/images/user/01.jpg" alt="story-img" class="rounded-circle avatar-40"></div>
                <div class="media-support-info ml-3">
                  <h6>Georgia</h6>
                  <p class="mb-0">Georgia State</p>
                </div>
                <div class="edit-relation"><a href="#"><i class="ri-edit-line mr-2"></i>Edit</a></div>
              </li>
            </ul>
            <h4 class="mt-3 mb-3">Other Places Lived</h4>
            <ul class="suggestions-lists m-0 p-0">
              <li class="d-flex mb-4 align-items-center">
                <div class="user-img img-fluid"><i class="ri-add-fill"></i></div>
                <div class="media-support-info ml-3">
                  <h6>Add Place</h6>
                </div>
              </li>
            </ul>
          </tab-content-item>
          <tab-content-item :active="false" id="about-info" aria-labelled-by="pills-about-info">
            <h4 class="mb-3">About You</h4>
            <p>Hi, I’m Bni, I’m 26 and I work as a Web Designer for the iqonicdesign.</p>
            <h4 class="mt-3 mb-3">Other Name</h4>
            <p>Bini Rock</p>
            <h4 class="mt-3 mb-3">Favorite Quotes</h4>
            <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s</p>
          </tab-content-item>
        </div>
      </div>
    </div>
</template>
<script>
import { socialvue } from '../../../../config/pluginInit'
export default {
  name: 'About',
  mounted () {
    socialvue.index()
  },
  components: {
  },
  data () {
    return {
      friend: [
        {
          img: require('../../../../assets/images/user/01.jpg'),
          name: 'Paul Molive',
          realtion: 'Brothe'
        },
        {
          img: require('../../../../assets/images/user/02.jpg'),
          name: 'Anna Mull',
          realtion: 'Sister'
        },
        {
          img: require('../../../../assets/images/user/03.jpg'),
          name: 'Paige Turner',
          realtion: 'Cousin'
        }
      ],
      work: [
        {
          img: require('../../../../assets/images/user/01.jpg'),
          name: 'Themeforest',
          des: 'Web Designer'
        },
        {
          img: require('../../../../assets/images/user/02.jpg'),
          name: 'iqonicdesign',
          des: 'Web Developer'
        },
        {
          img: require('../../../../assets/images/user/03.jpg'),
          name: 'W3school',
          des: 'Designer'
        }
      ]
    }
  }

}
</script>
