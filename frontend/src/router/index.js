import Vue from 'vue'
import Router from 'vue-router'
import Account from '@/components/Account'
import Role from '@/components/Role'
import Group from '@/components/Group'
import CandidateList from '@/components/CandidateList'
import Candidate from '@/components/Candidate'
import CandidatePage from '@/components/CandidatePage'
import Login from '@/components/Login'
import InterviewsPage from '@/components/InterviewsPage'
import InterviewPage from '@/components/InterviewPage'
import AppPage from '@/components/AppPage'

import ReportPage from '@/components/ReportPage'
import EmployeesPage from '@/components/EmployeesPage'
import RolesPage from '@/components/RolesPage'
import GroupsPage from '@/components/GroupsPage'

import Registration from '@/components/Registration'
import RoleRegistration from '@/components/RoleRegistration'
import GroupRegistration from '@/components/GroupRegistration'


import Home from '@/components/Home'


Vue.use(Router);


export default new Router({
    routes: [

        {
            path: '/',
            name: 'AppPage',
            component: AppPage,


            children: [
                {
                    path: '/home',
                    name: 'Home',
                    component: Home,
                },
                {
                    path: '/account',
                    name: 'Account',
                    component: Account,
                    props: true
                },
                {
                    path: '/role',
                    name: 'Role',
                    component: Role,
                    props: true
                },
                {
                    path: '/group',
                    name: 'Group',
                    component: Group,
                    props: true
                },
                {
                    path: '/registration',
                    name: 'Registration',
                    component: Registration,
                    props: true
                },
                {
                    path: '/roleregistration',
                    name: 'RoleRegistration',
                    component: RoleRegistration,
                    props: true
                },
                {
                    path: '/groupregistration',
                    name: 'GroupRegistration',
                    component: GroupRegistration,
                    props: true
                },
                {
                    path: '/employees',
                    name: 'EmployeesPage',
                    component: EmployeesPage,
                },
                {
                    path: '/roles',
                    name: 'RolesPage',
                    component: RolesPage,
                },
                {
                    path: '/groups',
                    name: 'GroupsPage',
                    component: GroupsPage,
                },
                {
                    path: '/page',
                    name: 'CandidatePage',
                    component: CandidatePage,
                },
                {
                    path: '/candidates/:id',
                    name: 'Candidate',
                    component: Candidate,
                    props: true
                },
                {
                    path: '/employees',
                    name: 'Employee',
                    component: Account,
                    props: true
                },
                {
                    path: '/candidates/',
                    name: 'CandidateList',
                    component: CandidateList
                },
                {
                    path: '/interviews/',
                    name: 'InterviewsPage',
                    component: InterviewsPage
                },
                {
                    path: '/interviews/:id',
                    name: 'InterviewPage',
                    component: InterviewPage,
                    props: true
                },
                {
                    path: '/reports/:id',
                    name: 'ReportPage',
                    component: ReportPage,
                    props: true
                }

            ]
        },
        {
            path: '/login',
            name: 'Login',
            component: Login,
        },

        {
            path: '/registration',
            name: 'Registration',
            component: Registration,
        },


    ]
})
