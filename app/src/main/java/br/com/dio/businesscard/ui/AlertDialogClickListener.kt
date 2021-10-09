package br.com.dio.businesscard.ui

interface AlertDialogClickListener {
    abstract fun setPositiveButton(s: String, onClickPositiveButtonListener: Unit)
}