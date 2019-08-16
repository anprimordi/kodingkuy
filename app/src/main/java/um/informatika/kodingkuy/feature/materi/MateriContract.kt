package um.informatika.kodingkuy.feature.materi

import um.informatika.kodingkuy.base.BasePresenter
import um.informatika.kodingkuy.base.BaseView
import um.informatika.kodingkuy.model.Materi

interface MateriContract {
    interface Presenter : BasePresenter {
        fun loadListMateri()
    }

    interface View : BaseView<Presenter> {
        fun onLoadListMateriSucceed(listMateri: List<Materi>)
    }
}