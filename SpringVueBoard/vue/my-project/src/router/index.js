import Vue from 'vue'
import Router from 'vue-router'
import ContentList from '@/components/ContentList'
import TodoPage from '@/components/TodoPage'
import Detail from '@/components/Detail'
import Create from '@/components/Create'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Content',
      component: ContentList,
      props: true
    },
    {
      path: '/detail/:num',
      name: 'Detail',
      component: Detail,
      props: true
    },
    {
      path: '/create/:num?',
      name: 'Create',
      component: Create,
      props:true
    },
    {
      path: '/todos',
      name: 'TodoPage',
      component: TodoPage,
      props: true
    }
  ]
})
