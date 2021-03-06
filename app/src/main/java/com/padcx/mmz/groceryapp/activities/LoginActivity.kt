package com.padcx.mmz.groceryapp.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.dynamiclinks.FirebaseDynamicLinks
import com.google.firebase.iid.FirebaseInstanceId
import com.padcx.mmz.groceryapp.R
import com.padcx.mmz.groceryapp.mvp.presenters.LoginPresenter
import com.padcx.mmz.groceryapp.mvp.presenters.impls.LoginPresenterImpl
import com.padcx.mmz.groceryapp.mvp.views.LoginView
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity(), LoginView {

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, LoginActivity::class.java)
        }
    }

    private lateinit var mPresenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        setSupportActionBar(findViewById(R.id.toolbar))

        FirebaseInstanceId.getInstance().instanceId.addOnSuccessListener {
            Log.d("fbToken", it.token)
        }

        setUpPresenter()
        setUpActionListeners()
        mPresenter.onUiReady(this,this)

        FirebaseDynamicLinks.getInstance()
            .getDynamicLink(intent)
            .addOnSuccessListener {
                val deepLink = it.link
                deepLink?.let { deepLink ->
                    Log.d("deepLink", deepLink.toString())
                }
            }
            .addOnFailureListener {
                Log.d("error", it.localizedMessage)
            }
    }

    private fun setUpActionListeners() {
        btnLogin.setOnClickListener {
            when{
               etEmail.text.isNullOrBlank()-> etEmail.error = "Email is Required"
               etPassword.text.isNullOrBlank() -> etPassword.error = "Password required"
               else->{
                   mPresenter.onTapLogin(this,etEmail.text.toString(), etPassword.text.toString())
                }
            }
        }

        btnRegister.setOnClickListener {
            mPresenter.onTapRegister()
        }
    }

    private fun setUpPresenter() {
        mPresenter = getPresenter<LoginPresenterImpl, LoginView>()
    }

    override fun navigateToHomeScreen() {
        startActivity(MainActivity.newIntent(this))
        this.finish()
    }

    override fun navigateToRegisterScreen() {
        startActivity(RegisterActivity.newIntent(this))
    }

    override fun showError(error: String) {
        Toast.makeText(this,""+error, Toast.LENGTH_SHORT).show()
    }
}