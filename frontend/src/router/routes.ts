import VueRouter, { RouteConfig } from 'vue-router'

const routes: RouteConfig[] = [{
  path: '/',
  component: () => import('src/layouts/Template.vue'),
  children: [
    {
      path: '/login',
      component: () => import('src/pages/Login.vue')
    },
    {
      path: '/state',
      component: () => import('src/pages/PageSearchState.vue')
    },
  ]
},
  // Always leave this as last one,
  // but you can also remove it
  {
    path: '*',
    component: () => import('pages/Error404.vue')
  }
]
export default routes
