package com.padcx.mmz.groceryapp.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.padcx.mmz.groceryapp.R
import com.padcx.mmz.groceryapp.mvp.presenters.RegisterPresenter
import com.padcx.mmz.groceryapp.mvp.presenters.impls.RegisterPresenterImpl
import com.padcx.mmz.groceryapp.mvp.views.RegisterView
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
        mPresenter.onUiReady(this, this)
    }

    private fun setUpActionListeners() {
        btnRegister.setOnClickListener {

            when{
                etEmail.text.isNullOrBlank()-> etEmail.error = "Email is Required"
                etUserName.text.isNullOrBlank() -> etPassword.error = "UserName required"
                etPassword.text.isNullOrBlank() -> etPassword.error = "Password required"
                else->{
                    mPresenter.onTapRegister(
                        this,
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
        this.finish()
    }

    override fun showError(error: String) {
        Toast.makeText(this,"Error"+error,Toast.LENGTH_SHORT).show()
    }
}