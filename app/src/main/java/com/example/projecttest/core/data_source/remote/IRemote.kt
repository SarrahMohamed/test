package com.example.projecttest.core.data_source.remote

interface IRemote <T> {
    fun getData(url :String) :T
}