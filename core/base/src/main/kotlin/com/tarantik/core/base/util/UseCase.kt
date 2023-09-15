package com.tarantik.core.base.util

import com.tarantik.core.base.arch.Result

interface UseCaseInput

interface UseCase<Input : UseCaseInput, Output> {
    suspend fun execute(input: Input): Result<Output>
}

interface UseCaseInputLess<Output> : UseCase<Nothing, Output> {
    override suspend fun execute(input: Nothing): Result<Output> = execute()
    suspend fun execute(): Result<Output>
}