<template>
  <b-container fluid>
    <b-row>
      <div class="col-sm-12">
          <div class="iq-card position-relative inner-page-bg bg-primary" style="height: 150px;">
            <div class="inner-page-title">
                <h3 class="text-white">FAQ Page</h3>
                <p class="text-white">lorem ipsum</p>
            </div>
          </div>
      </div>
      <b-col lg="6">
        <div class="iq-accordion career-style faq-style  ">
          <iq-card class="iq-card iq-accordion-block" :class="item.active ? 'accordion-active' : ''" v-for="(item,index) in faqList" :key="index">
            <div class="clearfix" :class="item.active ? 'active-faq' : ''">
              <div class="container">
                <b-row class="py-2" >
                  <b-col sm="12"><a class="accordion-title"><span> {{ item.title }} </span> </a></b-col>
                </b-row>
              </div>
            </div>
            <div class="accordion-details">
              <p class="mb-0">{{ item.description }} </p>
            </div>
          </iq-card>
        </div>
      </b-col>
      <b-col lg="6">
        <div class="iq-accordion career-style faq-style  ">
          <iq-card class="iq-card iq-accordion-block" :class="item.active ? 'accordion-active' : ''" v-for="(item,index) in faqList" :key="index">
            <div class="clearfix" :class="item.active ? 'active-faq' : ''">
              <div class="container">
                <b-row class="py-2">
                  <b-col sm="12"><a class="accordion-title"><span> {{ item.title }} </span> </a></b-col>
                </b-row>
              </div>
            </div>
            <div class="accordion-details">
              <p class="mb-0">{{ item.description }} </p>
            </div>
          </iq-card>
        </div>
      </b-col>
    </b-row>
  </b-container>
</template>
<script>
import { socialvue } from '../../config/pluginInit'

export default {
  name: 'FAQ',
  mounted () {
    socialvue.index()
  },
  data () {
    return {
      faqList: [
        {
          title: 'It is a long established fact that a reader will be?',
          description: 'Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for \'lorem ipsum\' will uncover many web sites still in their infancy.',
          active: false
        },
        {
          title: 'Distracted by the readable content of a page whent?',
          description: 'It has survived not only five centuries, but also the leap into electronic typesetting. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur.',
          active: false
        },
        {
          title: 'What is user interface kit?',
          description: 'It has survived not only five centuries, but also the leap into electronic typesetting. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur.',
          active: false
        },
        {
          title: 'The readable content of a page when looking at its layout?',
          description: 'It has survived not only five centuries, but also the leap into electronic typesetting. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur.',
          active: false
        },
        {
          title: 'It is a long established fact that a reader will be?',
          description: 'Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for \'lorem ipsum\' will uncover many web sites still in their infancy.',
          active: false
        },
        {
          title: 'Distracted by the readable content of a page whent?',
          description: 'It has survived not only five centuries, but also the leap into electronic typesetting. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur.',
          active: false
        },
        {
          title: 'What is user interface kit?',
          description: 'It has survived not only five centuries, but also the leap into electronic typesetting. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur.',
          active: false
        }
      ]
    }
  }
}
</script>
