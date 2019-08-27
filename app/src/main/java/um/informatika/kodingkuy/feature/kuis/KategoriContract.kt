package um.informatika.kodingkuy.feature.kuis

import um.informatika.kodingkuy.base.BasePresenter
import um.informatika.kodingkuy.base.BaseView
import um.informatika.kodingkuy.model.Kategori

interface KategoriContract {
    interface Presenter : BasePresenter {
        fun loadListKuis()
    }

    interface View : BaseView<Presenter> {
        fun onLoadListKuisSucceed(listKategori: List<Kategori>)
    }
}