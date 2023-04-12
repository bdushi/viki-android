package al.viki.core.di

import al.viki.core.model.User
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserProvider  @Inject constructor(){
    var user: User? = null
}