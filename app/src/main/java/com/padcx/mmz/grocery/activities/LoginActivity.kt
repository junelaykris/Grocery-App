package com.padcx.mmz.grocery.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.padcx.mmz.grocery.R
import com.padcx.mmz.grocery.mvp.presenters.LoginPresenter
import com.padcx.mmz.grocery.mvp.presenters.impls.LoginPresenterImpl
import com.padcx.mmz.grocery.mvp.views.LoginView
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

        setUpPresenter()
        setUpActionListeners()
    }

    private fun setUpActionListeners() {
        btnLogin.setOnClickListener {
            when{
               etEmail.text.isNullOrBlank()-> etEmail.error = "Email is Required"
               etPassword.text.isNullOrBlank() -> etPassword.error = "Password required"
               else->{
                   mPresenter.onTapLogin(etEmail.text.toString(), etPassword.text.toString())
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
    }

    override fun navigateToRegisterScreen() {
        startActivity(RegisterActivity.newIntent(this))
    }

    override fun showError(error: String) {
        Toast.makeText(this,""+error, Toast.LENGTH_SHORT).show()
    }
}