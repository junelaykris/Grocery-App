package com.padcx.mmz.grocery.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.padcx.mmz.grocery.R
import com.padcx.mmz.grocery.mvp.presenters.RegisterPresenter
import com.padcx.mmz.grocery.mvp.presenters.impls.RegisterPresenterImpl
import com.padcx.mmz.grocery.mvp.views.RegisterView
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.activity_register.btnRegister
import kotlinx.android.synthetic.main.activity_register.etEmail
import kotlinx.android.synthetic.main.activity_register.etPassword

class RegisterActivity : BaseActivity(), RegisterView {

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, RegisterActivity::class.java)
        }
    }

    private lateinit var mPresenter: RegisterPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        setUpPresenter()
        setUpActionListeners()
    }

    private fun setUpActionListeners() {
        btnRegister.setOnClickListener {

            when{
                etEmail.text.isNullOrBlank()-> etEmail.error = "Email is Required"
                etUserName.text.isNullOrBlank() -> etPassword.error = "UserName required"
                etPassword.text.isNullOrBlank() -> etPassword.error = "Password required"
                else->{
                    mPresenter.onTapRegister(
                        etEmail.text.toString(),
                        etPassword.text.toString(),
                        etUserName.text.toString()
                    )
                }
            }
        }
    }

    private fun setUpPresenter() {
        mPresenter = getPresenter<RegisterPresenterImpl, RegisterView>()
    }

    override fun navigateToToLoginScreen() {
        startActivity(LoginActivity.newIntent(this))
    }

    override fun showError(error: String) {
        Toast.makeText(this,"Error"+error,Toast.LENGTH_SHORT).show()
    }
}