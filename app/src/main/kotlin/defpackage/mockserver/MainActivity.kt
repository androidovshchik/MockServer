package defpackage.mockserver

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import dagger.android.support.DaggerAppCompatActivity
import defpackage.mockserver.remote.ServerApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    private val disposable = CompositeDisposable()

    @Inject
    lateinit var serverApi: ServerApi

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        disposable.add(
            serverApi.getPosts()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    tv_json.text = """
                        Total count: ${it.count()}
                    """.trimIndent()
                }, {
                    Log.e(javaClass.simpleName, it.message, it)
                })
        )
    }

    override fun onDestroy() {
        disposable.dispose()
        super.onDestroy()
    }
}