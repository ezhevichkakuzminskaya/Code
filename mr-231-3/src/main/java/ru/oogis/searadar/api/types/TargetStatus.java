package ru.oogis.searadar.api.types;
/**
 * Перечисление для статуса цели.
 * TRACKED - цель отслеживается
 * LOST - цель потеряна
 * UNKNOWN - неизвестный статус цели
 * UNRELIABLE_DATA - ненадежные данные о цели
 */
public enum TargetStatus {
    TRACKED, LOST, UNKNOWN, UNRELIABLE_DATA
}
