package com.culture.shock.domain

interface DomainModel
object None : DomainModel
data class DomainListModel<T : DomainModel>(val list: List<T>) : DomainModel
data class DomainTypeModel<T>(val value: T) : DomainModel

inline fun <D, DL : DomainModel> List<D>.mapDomainListModel(
    transform: (D) -> DL
): DomainListModel<DL> = DomainListModel(map { transform(it) })
